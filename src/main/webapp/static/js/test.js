$(function(){
    getArticleSort();
})

function getArticleSort() {
    var url = "data";
    $.ajax({
        type: "GET",
        url: url,
        dataType : 'json', 
        data: {
        },
        success: function (data) {
            if(data != null){
            	var user = data.user;
            	console.log(data.userName);
            }
        },
        error: function (message) {
            console.log("系统出现异常！");
        }
    });
}
