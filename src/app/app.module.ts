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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';

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
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatGridListModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
