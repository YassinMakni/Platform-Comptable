package susitio.comptabilite.project.exceptions;

import java.io.Serializable;


public class BusinessException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMsg;

	public BusinessException(BusinessErrorsEnum bizEx) {
		this.errorMsg = bizEx.getMessage();
		this.errorCode = bizEx.getId();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
