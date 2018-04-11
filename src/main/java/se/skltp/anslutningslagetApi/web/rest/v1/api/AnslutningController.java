package se.skltp.anslutningslagetApi.web.rest.v1.api;

import io.swagger.annotations.Api;
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
import se.skltp.anslutningslagetApi.models.entity.GrupperadAnslutning;
import se.skltp.anslutningslagetApi.service.AnslutningService;
import se.skltp.anslutningslagetApi.service.GrupperadAnslutningService;
import se.skltp.anslutningslagetApi.service.impl.AnslutningCriteria;
import se.skltp.anslutningslagetApi.service.impl.DateServiceImpl;
import se.skltp.anslutningslagetApi.service.impl.Pair;
import se.skltp.anslutningslagetApi.web.rest.v1.dto.AnslutningDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController()
@RequestMapping(value = {"/v1/anslutningar"})
@Api(value = "anslutningar", description = "Information om anslutningar.")
public class AnslutningController {
    @Autowired
    private AnslutningService anslutningService;

    @Autowired
    private GrupperadAnslutningService grupperadAnslutningService;

    @Autowired
    private DateServiceImpl dateService;


    public static final String OPERATION_NOTES = "Det centrala objektet i applikationen är Anslutning. Här kan du få info om alla anslutningar, filtrera och sortera dem.";

    private static final Logger log = LoggerFactory.getLogger(AnslutningController.class);


    @ApiImplicitParams({
            @ApiImplicitParam(name = "vardenhet", dataType = "string", paramType = "query", required = false, value = "HSA-id för Vårdenhet"),
            @ApiImplicitParam(name = "vardgivare", dataType = "string", paramType = "query", required = false, value = "HSA-id för Vårdgivare"),
            @ApiImplicitParam(name = "tjanstekontrakt", dataType = "string", paramType = "query", required = false, value = "Tjänstekontrakt med huvudversion"),
            @ApiImplicitParam(name = "kallsystem", dataType = "string", paramType = "query", required = false, value = "HSA-id för kallsystem"),
            @ApiImplicitParam(name = "kategori", dataType = "string", paramType = "query", required = false, value = "Kategori"),
            @ApiImplicitParam(name = "organisatoriskenhet", dataType = "string", paramType = "query", required = false, value = "HSA-id för organisatorisk enhet för kliniskt ansvarig/journalförande medarbetare"),
            @ApiImplicitParam(name = "ursprungligkonsument", dataType = "string", paramType = "query", required = false, value = "Ursprunglig tjänstekonsument som efterfrågat informationen"),
            @ApiImplicitParam(name = "forstaAnslutningsDatum", dataType = "string", paramType = "query", required = false, value = "Om du vill ställa in konkreta datum så får du skriva datumen i formatet yyyyMMdd. Om du vill ställa in period så får du skriva så här:\n" +                     "yyyyMMdd-yyyyMMdd. Det passar bra att skriva yyyyMMdd- för alla datum efter detta datum och -yyyyMMdd om för alla datum före detta datum."),
            @ApiImplicitParam(name = "senasteAnslutningsDatum", dataType = "string", paramType = "query", required = false, value = "Om du vill ställa in konkreta datum så får du skriva datumen i formatet yyyyMMdd. Om du vill ställa in period så får du skriva så här:\n" +                    "yyyyMMdd-yyyyMMdd. Det passar bra att skriva yyyyMMdd- för alla datum efter detta datum och -yyyyMMdd om för alla datum före detta datum."),
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query", required = false, value = "Paginering - sidnummer (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query", required = false, value = "Paginering - antalet objekt per sida."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", required = false, value = "Fältnamnet att sortera på och i vilken riktning att sortera(ASC|DESC). Ex.: sort=name,DESC.")
    })
    @RequestMapping(value = {""}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Alla anslutningar i json format",
            notes = OPERATION_NOTES)

    public List<AnslutningDTO> getAnslutningarJson(@RequestParam(required = false) String kallsystem,
                                                   @RequestParam(required = false) String kategori,
                                                   @RequestParam(required = false) String organisatoriskenhet,
                                                   @RequestParam(required = false) String tjanstekontrakt,
                                                   @RequestParam(required = false) String ursprungligkonsument,
                                                   @RequestParam(required = false) String vardenhet,
                                                   @RequestParam(required = false) String vardgivare,
                                                   @RequestParam(required = false) String forstaAnslutningsDatum,
                                                   @RequestParam(required = false) String senasteAnslutningsDatum,
                                                   @RequestParam(required = false) String page,
                                                   @RequestParam(required = false) String size,
                                                   @RequestParam(required = false) String sort,
                                                   @PageableDefault(size = Integer.MAX_VALUE) Pageable pageRequest)
            throws ParseException {

        log.debug("REST request to get all anslutningar as json/xml");


        Pair<Date, Date> forstaAnslutningsInterval = dateService.parseInterval(forstaAnslutningsDatum);
        Pair<Date, Date> senasteAnslutningsInterval = dateService.parseInterval(senasteAnslutningsDatum);

        return convertToDTO(grupperadAnslutningService.findAll(new AnslutningCriteria
                (kallsystem, kategori, organisatoriskenhet,
                        tjanstekontrakt, ursprungligkonsument, vardenhet,
                        vardgivare, forstaAnslutningsInterval, senasteAnslutningsInterval), pageRequest));

    }

    private List<AnslutningDTO> convertToDTO(List<GrupperadAnslutning> all) {
        List<AnslutningDTO> dtos = new LinkedList<>();
        for(GrupperadAnslutning a : all){
            AnslutningDTO dto = new AnslutningDTO();
            dto.setKallsystem(a.getKallsystem());
            dto.setKategori(a.getKategori());
            dto.setOrganisatoriskenhet(a.getOrganisatoriskenhet());
            dto.setTjanstekontrakt(a.getTjanstekontrakt());
            dto.setUrsprungligkonsument(a.getUrsprungligkonsument());
            dto.setVardenhet(a.getVardenhet());
            dto.setVardgivare(a.getVardgivare());
            dto.setForstaAnslutningsDatum(dateService.df_long.format(a.getForstaAnslutningsDatum()));
            dto.setSenasteAnslutningsDatum(dateService.df_long.format(a.getSenasteAnslutningsDatum()));

            dtos.add(dto);
        }
        return dtos;

    }

}
