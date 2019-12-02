import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

//Objeto que Angular se encarga de instanciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {
  //Infiere / deduce a partir del valor ( "" es String)
  urlApiRest = "http://localhost:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  alCambira: any;

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest, nuevaCuenta, this.httpOptions);
    observable.subscribe((datos)=>{ // Datos en la cuenta con el ID
      this.alCambira(datos); //Probablemente actualiza la lista
      lambda(datos); // Invoca a la suscripcion del componente nuevo
    });
    return observable;
  }

  public traerTodos(): Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }

  public eliminarCuenta(id: number) {

    return this.httpCli.delete(this.urlApiRest + "/" + id);
  }



}
