package com.naim.spring_test.model.response;

public class CommonResponse extends BaseResponse {
	private Object data=null;
	
	public CommonResponse(CommonResponseBuilder builder) {
		super(builder.status, builder.message);
		this.data=builder.data;
	}
	
	public Object getData() {
		return data;
	}

	public static class CommonResponseBuilder{
		private String status;
		private String message;
		private Object data;
		
		public CommonResponseBuilder(String status, String message) {
			this.status = status;
			this.message=message;
		}
		
		public CommonResponseBuilder data(Object data) {
			this.data=data;
			return this;
		}
		
		public CommonResponse build() {
			CommonResponse commonResponse = new CommonResponse(this);
			return commonResponse;
		}
	}
}
