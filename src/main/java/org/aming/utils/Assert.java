package org.aming.utils;

 
public abstract class Assert {
	
	/*public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}*/
	
	public static void notNull(Enum from ,Enum targ ,String msg){
		if(from == null || targ == null){
			throw new IllegalArgumentException(msg);
		}
	}
}
