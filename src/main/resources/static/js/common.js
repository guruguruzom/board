
this.commonJS = new commonClass(); 

function commonClass(){
	this.callAjax = function(url, type, data, successAction, failureAction) {
		
		$.ajax({
			url : url,
			type : type,
			data : data,
			accept: 'application/json',
			contentType:'application/json',
			dataType : 'json',
			beforeSend: function(xmlHttpRequest) {
				xmlHttpRequest.setRequestHeader("AJAX", "true");
			},
			success : function(response, status, xhr) {
				if (callbackSuccess != null) {
					callbackSuccess(response, status, xhr);
				}
			},
			error : function(xhr, status, errorThrown) {
				if (callbackFailure != null) {
					callbackFailure(xhr, status, errorThrown);
				} else {
					if(xhr.status == 200){
						return false;
					}
				}
			}
		});
	};
}