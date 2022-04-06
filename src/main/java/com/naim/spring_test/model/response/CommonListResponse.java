package com.naim.spring_test.model.response;

import java.util.List;

public class CommonListResponse extends BaseResponse {
	private List<?> data=null;
	
	public CommonListResponse(CommonListResponseBuilder builder) {
		super(builder.status, builder.message);
		this.data=builder.data;
	}
	
	public List<?> getData() {
		return data;
	}

	public static class CommonListResponseBuilder{
		private String status;
		private String message;
		private List<?> data;
		
		public CommonListResponseBuilder(String status, String message) {
			this.status = status;
			this.message=message;
		}
		
		public CommonListResponseBuilder data(List<?> data) {
			this.data=data;
			return this;
		}
		
		public CommonListResponse build() {
			CommonListResponse commonResponse = new CommonListResponse(this);
			return commonResponse;
		}
	}
}
