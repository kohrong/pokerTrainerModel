package pokerPlayerStatus;

public class HandStrength {
	public static final HandStrength VeryStrong = new HandStrength("VeryStrong");
	public static final HandStrength Strong = new HandStrength("Strong");
	public static final HandStrength Medium = new HandStrength("Medium");
	public static final HandStrength Nothing = new HandStrength("Nothing");
	
	private final String id;
	
	public HandStrength(String id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id;
	}
}
