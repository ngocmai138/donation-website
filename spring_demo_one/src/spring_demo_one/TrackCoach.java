package spring_demo_one;

public class TrackCoach implements Coach{
	private FortuneService theFortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		theFortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartUpStuff");
	}
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanUpStuff");
	}
}
