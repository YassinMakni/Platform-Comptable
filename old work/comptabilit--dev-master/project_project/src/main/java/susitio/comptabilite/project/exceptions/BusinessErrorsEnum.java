package susitio.comptabilite.project.exceptions;

public enum BusinessErrorsEnum {

	ERROR1(1, "Email not found"),
	ERROR2(2, "Email already exists"),
	ERROR3(3, "Id not found"),
	ERROR4(5, "User not found");

	private final int id;
	private final String message;

	BusinessErrorsEnum(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return id + " : " + message;
	}

}
