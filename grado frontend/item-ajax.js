$(document).ready(function () {
 getPageData();

//  Get Page Data
  function getPageData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/grado",
        contentType:'application/json',
        success: function(data){
          console.log("success", data);
          manageRow(data)
        }
        
       });
    };
  

  /* Add new Item table row */
  function manageRow(data) {
    var rows = "";
    $.each(data, function (key, value) {
      rows = rows + "<tr>";
      rows = rows + "<td>" + value.type + "</td>";
      rows = rows + "<td>" + value.studentLimit + "</td>";
      rows = rows + "<td>" + value.name + "</td>";

      rows = rows + '<td data-id="' + value.id + '">';
      rows = rows + 
      '<button data-toggle="modal" data-target="#edit-item" class="btn btn-primary edit-item">Edit'+
      //'<button data-toggle="modal" data-target="#edit-item" class="btn btn-link edit-item">'+  
      //'<span class="glyphicon glyphicon-pencil"></span>'+
      '</button>';
      rows = rows + 
      '<button class="btn btn-danger remove-item">Delete'+
      //'<button class="btn btn-link remove-item">'+
      //'<span class="glyphicon glyphicon-trash"></span>'+
      '</button>';
      rows = rows + "</td>";
      rows = rows + "</tr>";
    });
    $("tbody").html(rows);
  }

  /* Create new Item */
  $(".crud-submit").click(function (e) {
    var gradotype = $("#create-item").find("input[name='gradotype']").val();
    var limitealumnos = $("#create-item").find("input[name='limitealumnos']").val();
    var nombregrado = $("#create-item").find("input[name='nombregrado']").val();
    console.log(gradotype+limitealumnos+nombregrado);
          $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/grado",
            contentType:'application/json',
            data: JSON.stringify({ type: gradotype, 
                    studentLimit: limitealumnos, 
                    name: nombregrado
                   }),
            success: function (data){
              console.log(data)
              getPageData()
              $("#create-item").hide;
            }

            
          });
          return false;
  });

  /* Remove Item */
  $("body").on("click", ".remove-item", function () {
    var id = $(this).parent("td").data("id");
    var c_obj = $(this).parents("tr");
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/api/grado/" + id,

      success: function(data){
        console.log(data)
        c_obj.remove();
       toastr.success("Item borrado correctamente", "Success Alert")
       getPageData();
      }
      
    });
  });

  /* Edit Item */
  $("body").on("click", ".edit-item", function () {
    var id = $(this).parent("td").data("id");
    
    var gradotype = $(this).parent("td").prev("td").prev("td").prev("td").text();
    var limitealumnos = $(this).parent("td").prev("td").prev("td").text();
    var nombregrado = $(this).parent("td").prev("td").text();
    
    $("#edit-item").find("input[name='gradotype']").val(gradotype);
    $("#edit-item").find("input[name='limitealumnos']").val(limitealumnos);
    $("#edit-item").find("input[name='nombregrado']").val(nombregrado);

    $("#edit-item").find(".edit-id").val(id);
  });

  /* Updated new Item */
  $(".crud-submit-edit").click(function (e) {
    var id = $("#edit-item").find(".edit-id").val();

    var gradotype = $("#edit-item").find("input[name='gradotype']").val();
    var limitealumnos = $("#edit-item").find("input[name='limitealumnos']").val();
    var nombregrado = $("#edit-item").find("input[name='nombregrado']").val();

      $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/grado/" + id,
        contentType:'application/json',
            data: JSON.stringify({ 
                    id: id,
                    type: gradotype, 
                    studentLimit: limitealumnos, 
                    name: nombregrado
                   }),
            success: function (data){
              console.log(data)
              getPageData()
              $("#create-item").hide;
            }
          });
          return false;
  });
});