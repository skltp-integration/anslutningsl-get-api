package se.skltp.anslutningslagetApi.web.rest.v1.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;
import se.skltp.anslutningslagetApi.service.AnslutningService;
import se.skltp.anslutningslagetApi.service.impl.AnslutningCriteria;
import se.skltp.anslutningslagetApi.web.rest.v1.dto.AnslutningDTO;

import java.util.LinkedList;
import java.util.List;

@RestController()
@RequestMapping(value = { "/v1/anslutningar"})
public class AnslutningController {
    @Autowired
    private AnslutningService anslutningService;

    private static final Logger log = LoggerFactory.getLogger(AnslutningController.class);

    public static final String OPERATION_NOTES = "Hämtar data om alla anslutningar.";



    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Paginering - sidnummer (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Paginering - antalet objekt per sida."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Fältnamnet att sortera på och i vilken riktning att sortera(ASC|DESC). Ex.: sort=name,DESC.")})
    @RequestMapping( value={""}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
            @ApiOperation(value = "Alla anslutningar i json format",
                    notes = OPERATION_NOTES)
    public List<AnslutningDTO> getAnslutningarJson(@RequestParam(required = false) String kallsystem,
                                                   @RequestParam(required = false) String kategori,
                                                   @RequestParam(required = false) String organisatoriskenhet,
                                                   @RequestParam(required = false) String tjanstekontrakt,
                                                   @RequestParam(required = false) String ursprungligkonsument,
                                                   @RequestParam(required = false) String vardenhet,
                                                   @RequestParam(required = false) String vardgivare,
                                                   @PageableDefault(size = Integer.MAX_VALUE) Pageable pageRequest) {
        log.debug("REST request to get all anslutningar as json/xml");


        return convertToDTO(anslutningService.findAll(new AnslutningCriteria(kallsystem, kategori, organisatoriskenhet, tjanstekontrakt, ursprungligkonsument, vardenhet, vardgivare), pageRequest));
    }

    private List<AnslutningDTO> convertToDTO(List<Anslutning> all) {
        List<AnslutningDTO> dtos = new LinkedList<>();
        for(Anslutning a : all){
            AnslutningDTO dto = new AnslutningDTO();
            dto.setKallsystem(a.getKallsystem().getName());
            dto.setKategori(a.getKategori().getName());
            dto.setOrganisatoriskenhet(a.getOrganisatoriskenhet().getName());
            dto.setTjanstekontrakt(a.getTjanstekontrakt().getName());
            dto.setUrsprungligkonsument(a.getUrsprungligkonsument().getName());
            dto.setVardenhet(a.getVardenhet().getName());
            dto.setVardgivare(a.getVardgivare().getName());
            dtos.add(dto);
        }
        return dtos;

    }

}
