package se.skltp.anslutningslgetApi.web.rest.v1.api;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.skltp.anslutningslgetApi.dao.AnslutningDAO;
import se.skltp.anslutningslgetApi.models.entity.Anslutning;
import se.skltp.anslutningslgetApi.web.rest.v1.dto.AnslutningDTO;

import java.util.LinkedList;
import java.util.List;

@RestController()
@RequestMapping(value = { "/v1/anslutningar"})
public class AnslutningController {
    @Autowired
    private AnslutningDAO anslutningDao;

    private static final Logger log = LoggerFactory.getLogger(AnslutningController.class);

    public static final String OPERATION_NOTES = "Hämtar data om alla anslutningar.";


    @ApiOperation(value = "Alla anslutningar i text format",
            notes = OPERATION_NOTES)
    @RequestMapping(value={"txt"}, method = RequestMethod.GET)
    public String getAnslutningarTxt() {
        return "";
    }


    @ApiOperation(value = "Alla anslutningar i json format",
            notes = OPERATION_NOTES)
    @RequestMapping( value={""}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AnslutningDTO> getAnslutningarJson() {
        log.debug("REST request to get all anslutningar as json/xml");

        return convertToDTO(anslutningDao.getAll());
    }

    private List<AnslutningDTO> convertToDTO(List<Anslutning> all) {
        List<AnslutningDTO> dtos = new LinkedList<>();
        for(Anslutning a:all){
            dtos.add(new AnslutningDTO());
        }
        return dtos;

    }

}
