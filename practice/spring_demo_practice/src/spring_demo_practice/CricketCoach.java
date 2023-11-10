package spring_demo_practice;

public class CricketCoach implements Coach{
	private String emailAddress;
	private String team;
	private FortuneService theFortuneService;
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg construction");
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling or 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}
	public void setTheFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setTheFortuneService");
		theFortuneService = fortuneService;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: inside setter method - setTeam	");
	}

}
