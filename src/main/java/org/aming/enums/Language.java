package org.aming.enums;

public enum Language {
	EN(1,"EN"),
	ZH_CN(2,"ZH_CN");
	private int id;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private Language(int id,String status){
		this.id = id;;
		this.status = status;
	}
	
	public static Language getLanguage(int status){
		for(Language l:values()){
			if(l.id == status){
				return l;
			}
		}
		return null;
	}
	
	public static Language getLanguage(String status){
		for(Language l:values()){
			if(StringUtils.equalsIgnoreCase(l.status, status)){
				return l;
			}
		}
		return null;
	}
}

