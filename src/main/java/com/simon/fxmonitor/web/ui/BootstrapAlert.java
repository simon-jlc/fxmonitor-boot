package com.simon.fxmonitor.web.ui;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
@Data
@Getter
@Setter
public class BootstrapAlert {
	private String msg;
	private String type;
	
	public BootstrapAlert (BootstrapAlertType bootstrapAlertType, String msg) {
		this.type = bootstrapAlertType.type;
		this.msg = msg;
	}
	
	public enum BootstrapAlertType {
		SUCCESS("success"), INFO("info"), WARNING("warning"), DANGER("danger");
		
		@Getter
		private String type;
		
		private BootstrapAlertType(String type) {
			this.type = type;
		}
	}
}