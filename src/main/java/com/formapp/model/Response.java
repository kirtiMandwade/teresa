package com.formapp.model;

import java.io.Serializable;

public class Response implements Serializable{

		private String divData;
		private String filename;

		public String getDivData() {
			return divData;
		}

		public void setDivData(String divData) {
			this.divData = divData;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}
		
		
		
	}
