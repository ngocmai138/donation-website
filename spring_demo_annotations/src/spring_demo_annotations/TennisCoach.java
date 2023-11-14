package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach{
	@Autowired
//	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	public TennisCoach() {
		System.out.println("TennisCoach: inside defaut constructor");
	}
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">>TennisCoach: inside setFortuneService method");
//		this.fortuneService = fortuneService;
//	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
//	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("TennisCoach: Inside of doMyStartUpStuff");
	}
	
//	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: Inside of doMyCleanupStuff");
	}

}
