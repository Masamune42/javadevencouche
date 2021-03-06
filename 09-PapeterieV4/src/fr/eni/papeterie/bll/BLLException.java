package fr.eni.papeterie.bll;

@SuppressWarnings("serial")
public class BLLException extends Exception {
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exc) {
		super(message, exc);
	}
	
	
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());

		return sb.toString();
	}
	
}
