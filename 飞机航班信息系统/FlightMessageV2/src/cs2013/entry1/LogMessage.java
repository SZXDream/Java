package cs2013.entry1;

public class LogMessage {
	private int id;
	private String logLevel;
	private String useTime;
	private String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LogMessage() {
		super();
	}
	public LogMessage(int id, String logLevel, String useTime, String msg) {
		super();
		this.id = id;
		this.logLevel = logLevel;
		this.useTime = useTime;
		this.msg = msg;
	}
	
	
	
}
