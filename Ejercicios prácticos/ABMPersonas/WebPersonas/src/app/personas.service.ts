import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from './persona';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {

  constructor(private http: HttpClient) { }


  public consultarPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>("http://localhost:8080/persona")
  }

}
