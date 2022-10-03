import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageaccueilComponent } from './pageaccueil/pageaccueil.component';
import { AffichageDesCentresComponent } from './affichage-des-centres/affichage-des-centres.component';
import { InformationsSurLutilisateurComponent } from './informations-sur-lutilisateur/informations-sur-lutilisateur.component';
import { ConfirmationDeRendezVousComponent } from './confirmation-de-rendez-vous/confirmation-de-rendez-vous.component';
import { PageClientsComponent } from './page-clients/page-clients.component';

@NgModule({
  declarations: [
    AppComponent,
    PageaccueilComponent,
    AffichageDesCentresComponent,
    InformationsSurLutilisateurComponent,
    ConfirmationDeRendezVousComponent,
    PageClientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
