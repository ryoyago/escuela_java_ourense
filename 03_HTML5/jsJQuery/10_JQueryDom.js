//jQuery(...) se abrevia como$(...)
jQuery(document).ready(function () {
    $("article").hide();
    jQuery("section").append("<div><p>LEYENDA DE LO QUE SEA</p></div>");



    $(".articulo").append("<p>UN PARRAFO EN CADA ELEMENTO con class= 'articulo'</p>");
    $("tr").append("<td>Info</td>");//añadir quinta columna
    $("tr:nth-child(5)").attr("style", "background-color: red; color: white");
    $("tr:nth-child(5)").click(() => {
        alert('un click desde jq')
    }
    );

    $("#otro_menu").html("<h2>Menu de articulos</h2><br/><br/>");

    /*
    $("article").
        ;*/

    $("article").each(function (index) { //es hacer un for__________________
        let idArticulo = "articulo_123456789_" + index;
        $(this).attr("id", idArticulo);
        $("#otro_menu").append("<a href='#" + idArticulo + "'class='enlace-articulo'>Articulo nº " + index + " </a>")

    }
    );
    $("#otro_menu a").click(function () {
        let idHref = $(this).attr("href");
        $("article").hide();
        $(idHref).slideToggle();

    });
    

    $("h4").click(function () {
        $(this).siblings().slideToggle();
    });

    $("#otro_menu").append("<p>Soy como el cosmos, si me tocas me voy me desvanezco </p><br/><br/>")
    /*  $("#otro_menu").click(function () {
          //$("#otro_menu").fadeOut();
          //$("#otro_menu").slideUp();
          //$("#otro_menu").slideDown();
          $("#otro_menu").slideToggle();
          $("#otro_menu").css({ 'color': 'red', 'font-size': '1.3em', 'background': 'yellow' });
          $("#apocalipsis").click(function () {
              $("#body").hide();
          })
      });*/

});