
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptorService } from './services/auth-interceptor.service';
import { MessageService } from './services/message.service';
import { ClientComponent } from './components/client/client.component';
import { ClientService } from './services/client.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component, ChangeDetectorRef } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DocumentComponent } from './components/document/document.component';
import { DocumentService } from './services/document.service';
import { LeftSidebarComponent } from './components/left-sidebar/left-sidebar.component';
import { TemplateAdminComponent } from './components/admin/template-admin.component';
import { AdminLeftSidebarComponent } from './components/admin/admin-left-sidebar/admin-left-sidebar.component';
import { AdminPageContentComponent } from './components/admin/admin-page-content/admin-page-content.component';
import { EmailComposeComponent } from './components/email/email-compose/email-compose.component';
import { EmailReadComponent } from './components/email/email-read/email-read.component';
import { EmailInboxComponent } from './components/email/email-inbox/email-inbox.component';
import { StatistiqueComponent } from './components/admin/statistique/statistique.component';
import { CollaborateurComponent } from './components/collaborateur/collaborateur.component';
import { ListCollaborateurComponent } from './components/collaborateur/list-collaborateur/list-collaborateur.component';
import { NewCollaborateurComponent } from './components/collaborateur/new-collaborateur/new-collaborateur.component';
import { ProfileCollaborateurComponent } from './components/collaborateur/profile-collaborateur/profile-collaborateur.component';
import { EditCollaborateurComponent } from './components/collaborateur/edit-collaborateur/edit-collaborateur.component';
import { ListDocumentComponent } from './components/document/list-document/list-document.component';
import { BilanAnnuelComponent } from './components/document/list-document/sous-list-document/bilan-annuel/bilan-annuel.component';
import { BilanMoisComponent } from './components/document/list-document/sous-list-document/bilan-mois/bilan-mois.component';
import { SousListDocumentComponent } from './components/document/list-document/sous-list-document/sous-list-document.component';
import { InscriptionComponent } from './components/client/inscription/inscription.component';
import { AddCollaborateurComponent } from './components/collaborateur/add-collaborateur/add-collaborateur.component';
import { CollaborateurService } from './services/collaborateur.service';
import { ListClientNonValideComponent } from './components/client/list-client-non-valide/list-client-non-valide.component';
import { EmailComposeClientComponent } from './components/email/email-compose-client/email-compose-client.component';
import { RouterModule } from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { ClientLeftSidebarComponent } from './components/client/client-left-sidebar/client-left-sidebar.component';
import { ClientPageContentComponent } from './components/client/client-page-content/client-page-content.component';
import {Nl2BrPipeModule} from 'nl2br-pipe';
import { ProfileClientComponent } from './components/client/profile-client/profile-client.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { HomeTemplateComponent } from './components/home-template/home-template.component';
import { HomeComponent } from './components/home-template/home/home.component';
import { DossierJuridiqueComponent } from './components/document/list-document/sous-list-document/dossier-juridique/dossier-juridique.component';
import { ViewDocumentComponent } from './components/document/view-document/view-document.component';
import { SafePipe } from './services/safe-pipe.service';
import { BilanMoisDetailsComponent } from './components/document/list-document/sous-list-document/bilan-mois/bilan-mois-details/bilan-mois-details.component';
import { Page404Component } from './components/page404/page404.component';
import { AboutComponent } from './components/home-template/about/about.component';
import { AuditEtCertificationComponent } from './components/home-template/audit-et-certification/audit-et-certification.component';
import { AssistanceJuridiqueComponent } from './components/home-template/assistance-juridique/assistance-juridique.component';
import { ConseilEnManagementComponent } from './components/home-template/conseil-en-management/conseil-en-management.component';
import { ServicesAuxEntrepreneursComponent } from './components/home-template/services-aux-entrepreneurs/services-aux-entrepreneurs.component';
import { ConseilEnTransactionsComponent } from './components/home-template/conseil-en-transactions/conseil-en-transactions.component';
import { ExpertiseComponent } from './components/home-template/expertise/expertise.component';
import { CarriereComponent } from './components/home-template/carriere/carriere.component';
import { ContactComponent } from './components/home-template/contact/contact.component';
import { NgxEditorModule } from 'ngx-editor';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { AddDocumentNewsComponent } from './components/document/add-document-news/add-document-news.component';
import { ListDocumentActualiteComponent } from './components/document/list-document-actualite/list-document-actualite.component';
import { ListDocumentConventionComponent } from './components/document/list-document-convention/list-document-convention.component';
import { ActualiteComponent } from './components/home-template/actualite/actualite.component';
import { ConventionComponent } from './components/home-template/convention/convention.component';
import { PdfDetailsComponent } from './components/home-template/pdf-details/pdf-details.component';
import { NavbarAdminComponent } from './components/admin/navbar-admin/navbar-admin.component';
import { NavbarClientComponent } from './components/client/navbar-client/navbar-client.component';
import { AddDocumentAdminComponent } from './components/admin/add-document-admin/add-document-admin.component';
import { AddDocumentComponent } from './components/client/add-document/add-document.component';
import { ProfilClientAdminComponent } from './components/admin/profil-client-admin/profil-client-admin.component';
import { ListClientComponent } from './components/admin/list-client/list-client.component';
import { ListDocumentClientComponent } from './components/admin/list-document-client/list-document-client.component';
import { BigFolderComponent } from './components/admin/list-document-client/big-folder/big-folder.component';
import { MensuelFolderComponent } from './components/admin/list-document-client/mensuel-folder/mensuel-folder.component';
import { DetailDocumentComponent } from './components/admin/list-document-client/detail-document/detail-document.component';
import { FolderDetailComponent } from './components/admin/list-document-client/folder-detail/folder-detail.component';

@NgModule({
  declarations: [
    SafePipe,
    AppComponent,
    ClientComponent,
    DocumentComponent,
    AddDocumentComponent,
    ListClientComponent,
    LeftSidebarComponent,
    TemplateAdminComponent,
    AdminLeftSidebarComponent,
    AdminPageContentComponent,
    EmailComposeComponent,
    EmailReadComponent,
    EmailInboxComponent,
    StatistiqueComponent,
    CollaborateurComponent,
    ListCollaborateurComponent,
    NewCollaborateurComponent,
    ProfileCollaborateurComponent,
    EditCollaborateurComponent,
    ListDocumentComponent,
    BilanAnnuelComponent,
    BilanMoisComponent,
    SousListDocumentComponent,
    AddDocumentAdminComponent,
    InscriptionComponent,
    AddCollaborateurComponent,
    ListClientNonValideComponent,
    EmailComposeClientComponent,
    ClientLeftSidebarComponent,
    ClientPageContentComponent,
    ProfileClientComponent,
    EditClientComponent,
    HomeTemplateComponent,
    HomeComponent,
    DossierJuridiqueComponent,
    ViewDocumentComponent,
    BilanMoisDetailsComponent,
    Page404Component,
    AboutComponent,
    AuditEtCertificationComponent,
    AssistanceJuridiqueComponent,
    ConseilEnManagementComponent,
    ServicesAuxEntrepreneursComponent,
    ConseilEnTransactionsComponent,
    ExpertiseComponent,
    CarriereComponent,
    ContactComponent,
    AddDocumentNewsComponent,
    ListDocumentActualiteComponent,
    ListDocumentConventionComponent,
    ActualiteComponent,
    ConventionComponent,
    PdfDetailsComponent,
    LoginComponent,
    NavbarAdminComponent,
    NavbarClientComponent,
    ProfilClientAdminComponent,
    ListDocumentClientComponent,
    BigFolderComponent,
    MensuelFolderComponent,
    DetailDocumentComponent,
    FolderDetailComponent
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Nl2BrPipeModule,
    AppRoutingModule,
    NgxEditorModule,
    TooltipModule
  ],
  providers: [
    ClientService,
    DocumentService,
    CollaborateurService,
    MessageService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}