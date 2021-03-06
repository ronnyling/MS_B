package MS_B.Controllers;

import MS_B.Model.StaffB;
import MS_B.Services.SalesRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/msb") // This means URL's start with /demo (after Application path)
@Slf4j
public class MainController {

	@Autowired
	private SalesRecordService salesRecordService;
	RestTemplate restTemplate = new RestTemplate();


	/*
	@PostMapping(path="/getSales")
	public @ResponseBody SalesRecord getSalesRecord(@RequestBody StaffB staffB)  {
		try{
			log.info(staffB.toString());
            //staffB= mapper.readValue((JsonParser) httpEntity.getBody(),StaffB.class);
			//log.info(staffB.toString());
			SalesRecord salesRec = salesRecordRepository.getSalesRecord(staffB.getFName());
			return (salesRec);
		}catch(NullPointerException e){
			System.out.println(e.getStackTrace());
			return null;
		}
				//
	}
	@Autowired
	private SalesRecordRepository salesRecordRepository;
	@PostMapping(path="/getSalestest")
	public @ResponseBody String getSalesRecordtest(@RequestBody StaffB staffB)  {
		try{
			log.info(staffB.toString());
			//staffB= mapper.readValue((JsonParser) httpEntity.getBody(),StaffB.class);
			//log.info(staffB.toString());
			List some = salesRecordRepository.getSalesRecord(staffB.getFName());
			return some.toString();
		}catch(NullPointerException e){
			System.out.println(e.getStackTrace());
			return null;
		}
		//
	}*/

	@PostMapping(path="/getSales",produces = "application/json; charset=UTF-8")
	public ResponseEntity getSalesRecord (@RequestBody StaffB staffB) {
		return salesRecordService.getSalesRec(staffB);
	}
}
