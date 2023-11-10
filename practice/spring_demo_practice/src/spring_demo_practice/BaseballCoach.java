package spring_demo_practice;

public class BaseballCoach implements Coach{

	private FortuneService theFortuneService;
	public BaseballCoach(FortuneService fortuneService) {
		theFortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}

}
