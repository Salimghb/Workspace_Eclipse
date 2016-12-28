package tp6.exo1;

public class FormatException extends Exception {

	private static final long serialVersionUID = -3266359444148692588L;

	public FormatException() {

	}

	public FormatException(String arg0) {
		super(arg0);
	}

	public FormatException(Throwable arg0) {
		super(arg0);
	}

	public FormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FormatException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
