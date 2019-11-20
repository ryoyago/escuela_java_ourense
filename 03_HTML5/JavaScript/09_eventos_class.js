// Manera EcmasScript 5
function GestorEventosES5(inputId, btnId, divInfoId) {
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divInfoId);



    GestorEventosES5.prototype.funCallbkAlPulsa = function (evento) {

       // this.input.value = "Tipo evento: " + evento.type;
        this.divInfo.style="background-colo: red";
        
         if (evento.currentTarget.id == "btn_listo2") {
            input_listo.value = "Tipo Mandalorian: " + "Uso bluster";
        } else if (evento.currentTarget.id == "btn_listo") {
            input_listo2.value = "Tipo evento: " + "Obi Wan Puto amo";
        }

        if (this.boton.className=="btn-tam"){
            this.boton.classList.remove("btn-tam");
            this.boton.className="gatillazo";
        }else{
            this.boton.classList.remove("gatillazo");
            this.boton.className="btn-tam";
        }
    }

    GestorEventosES5.prototype.funCallbkOnClick_2 = (evento) => {
        if (evento.currentTarget.id == "btn_listo2") {
            document.getElementsByTagName("body")[0].className = "fondo-body";
        } else if (evento.currentTarget.id == "btn_listo") {
            document.getElementsByTagName("body")[0].className = "fondo-body2";
        }

    }
    this.boton.addEventListener("click", this.funCallbkAlPulsa.bind(this));
    this.boton.addEventListener("click", this.funCallbkOnClick_2);
    

}

class GestorEventosES6 { //Manera EcmaScript 2015 o ES6

    constructor(inputId, btnId, divInfoId) {
        this.input = document.getElementById(inputId);
        this.boton = document.getElementById(btnId);
        this.divInfo = document.getElementById(divInfoId);
        this.boton.addEventListener("click", this.funCallbkAlPulsa.bind(this));
    this.boton.addEventListener("click", this.funCallbkOnClick_2);
    }
    funCallbkAlPulsa(evento) {

        this.input.value = "Tipo evento: " + evento.type;

        


    }
    funCallbkOnClick_2 = (evento) => {
        this.input.style = "background-color: lightblue;"
        this.divInfo.style="background-colo: red";
    }

}