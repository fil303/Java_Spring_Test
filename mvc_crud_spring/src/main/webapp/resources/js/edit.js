$(".edit").click(function(){
    var id = $(this).data("id");
    $.get("http://localhost:8080/edit/"+id,function(data){
        $("#edit_user").html(data);
        $("#editEmployeeModal").modal("hide");
        $("#editEmployeeModal").modal("show");
        console.log(data);
    });
});
$(".delete_btn").click(function(){
    $(".delete_form").attr("action","delete/"+$(this).data("id"));
});
