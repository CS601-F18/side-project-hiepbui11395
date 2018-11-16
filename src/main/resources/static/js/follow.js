function follow(button, data, type, buttonStr){
    $.ajax({
        type : "POST",
        url : "/api/accounts/follow",
        data : {
            id : data[0],
            relationshipType: type
        },
        success : function(result) {
            $(button).html(buttonStr)
            if(type==0){
                $(button).val(1)
            } else{
                $(button).val(0)
            }
        },
        error : function(result) {
            // do something.
        }
    });
}