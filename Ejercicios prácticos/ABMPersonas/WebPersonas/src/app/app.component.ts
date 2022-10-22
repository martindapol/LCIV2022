import { Component, OnInit } from '@angular/core';
import { Persona } from './persona';
import { PersonasService } from './personas.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  public lista: Persona[] 

  ngOnInit(): void {
    this.personas.consultarPersonas().subscribe({
      next: (data) => { this.lista = data }
    })
    
  }

  constructor(private personas: PersonasService) {
    this.lista = []
  }

  title = 'WebPersonas';

  

}
