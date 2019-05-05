import { FolderDetailComponent } from './components/admin/list-document-client/folder-detail/folder-detail.component';
import { MensuelFolderComponent } from './components/admin/list-document-client/mensuel-folder/mensuel-folder.component';
import { BigFolderComponent } from './components/admin/list-document-client/big-folder/big-folder.component';
import { EmailReadComponent } from './components/email/email-read/email-read.component';
import { EmailInboxComponent } from './components/email/email-inbox/email-inbox.component';
import { EmailComposeComponent } from './components/email/email-compose/email-compose.component';
import { ListClientNonValideComponent } from './components/client/list-client-non-valide/list-client-non-valide.component';
import { ProfileCollaborateurComponent } from './components/collaborateur/profile-collaborateur/profile-collaborateur.component';
import { AddCollaborateurComponent } from './components/collaborateur/add-collaborateur/add-collaborateur.component';
import { ListCollaborateurComponent } from './components/collaborateur/list-collaborateur/list-collaborateur.component';
import { InscriptionComponent } from './components/client/inscription/inscription.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateAdminComponent } from './components/admin/template-admin.component';
import { ClientComponent } from './components/client/client.component';
import { CollaborateurComponent } from './components/collaborateur/collaborateur.component';
import { DocumentComponent } from './components/document/document.component';
import { EmailComposeClientComponent } from './components/email/email-compose-client/email-compose-client.component';
import { ProfileClientComponent } from './components/client/profile-client/profile-client.component';
import { HomeTemplateComponent } from './components/home-template/home-template.component';
import { SousListDocumentComponent } from './components/document/list-document/sous-list-document/sous-list-document.component';
import { DossierJuridiqueComponent } from './components/document/list-document/sous-list-document/dossier-juridique/dossier-juridique.component';
import { ViewDocumentComponent } from './components/document/view-document/view-document.component';
import { BilanAnnuelComponent } from './components/document/list-document/sous-list-document/bilan-annuel/bilan-annuel.component';
import { BilanMoisComponent } from './components/document/list-document/sous-list-document/bilan-mois/bilan-mois.component';
import { BilanMoisDetailsComponent } from './components/document/list-document/sous-list-document/bilan-mois/bilan-mois-details/bilan-mois-details.component';
import { Page404Component } from './components/page404/page404.component';
import { HomeComponent } from './components/home-template/home/home.component';
import { AboutComponent } from './components/home-template/about/about.component';
import { AuditEtCertificationComponent } from './components/home-template/audit-et-certification/audit-et-certification.component';
import { AssistanceJuridiqueComponent } from './components/home-template/assistance-juridique/assistance-juridique.component';
import { ConseilEnManagementComponent } from './components/home-template/conseil-en-management/conseil-en-management.component';
import { ServicesAuxEntrepreneursComponent } from './components/home-template/services-aux-entrepreneurs/services-aux-entrepreneurs.component';
import { ConseilEnTransactionsComponent } from './components/home-template/conseil-en-transactions/conseil-en-transactions.component';
import { ExpertiseComponent } from './components/home-template/expertise/expertise.component';
import { CarriereComponent } from './components/home-template/carriere/carriere.component';
import { AddDocumentNewsComponent } from './components/document/add-document-news/add-document-news.component';
import { ListDocumentActualiteComponent } from './components/document/list-document-actualite/list-document-actualite.component';
import { ListDocumentConventionComponent } from './components/document/list-document-convention/list-document-convention.component';
import { ActualiteComponent } from './components/home-template/actualite/actualite.component';
import { PdfDetailsComponent } from './components/home-template/pdf-details/pdf-details.component';
import { ConventionComponent } from './components/home-template/convention/convention.component';
import { LoginComponent } from './components/login/login.component';
import { AddDocumentComponent } from './components/client/add-document/add-document.component';
import { AddDocumentAdminComponent } from './components/admin/add-document-admin/add-document-admin.component';
import { ListClientComponent } from './components/admin/list-client/list-client.component';
import { ProfilClientAdminComponent } from './components/admin/profil-client-admin/profil-client-admin.component';
import { ListDocumentClientComponent } from './components/admin/list-document-client/list-document-client.component';



const routes: Routes = [
  { path: 'admin', component: TemplateAdminComponent, children:[
    { path: 'client-list', component: ListClientComponent },
    { path: 'client-list-attente', component: ListClientNonValideComponent },
    { path: 'collaborateur-list', component: ListCollaborateurComponent },
    { path: 'collaborateur-new', component: AddCollaborateurComponent },
    { path: 'email-compose', component: EmailComposeComponent},
    { path: 'email-inbox', component: EmailInboxComponent},
    { path: 'email-read', component: EmailReadComponent},
    { path: 'document-add', component: AddDocumentAdminComponent},
    { path: 'document-add-news', component: AddDocumentNewsComponent},
    { path: 'document-actualite', component: ListDocumentActualiteComponent},
    { path: 'document-convention', component: ListDocumentConventionComponent},
    { path: 'profil-client/:id', component: ProfilClientAdminComponent},
    { path: 'list-document-client/:id', component: ListDocumentClientComponent},
    { path: 'sous-document/:annee', component: SousListDocumentComponent},
    { path: 'dossierJuridique/:annee', component: DossierJuridiqueComponent},
    { path: 'document-view/:id', component: ViewDocumentComponent},
    { path: 'anneeFolder/:id/:annee', component: BigFolderComponent},
    { path: 'mensuelFolder/:id/:annee', component: MensuelFolderComponent },
    { path: 'files/:folder/:id/:annee', component: FolderDetailComponent}
    ] 
  },
  { path: 'client', component: ClientComponent,children:[
    {path: 'email-compose', component: EmailComposeClientComponent},
    {path: 'email-read/:id', component: EmailReadComponent},
    {path: 'email-inbox', component: EmailInboxComponent},
    {path: 'document-add', component: AddDocumentComponent},
    {path: 'document', component: DocumentComponent},
    {path: 'profile', component: ProfileClientComponent},
    {path: 'sous-document/:annee', component: SousListDocumentComponent},
    {path: 'dossierJuridique/:annee', component: DossierJuridiqueComponent},
    {path: 'document-view/:id', component: ViewDocumentComponent},
    {path: 'bilanAnnuel/:annee', component: BilanAnnuelComponent},
    {path: 'bilanMensuel/:annee', component: BilanMoisComponent},
    {path: 'bilanMensuelDetails/:annee/:mois', component: BilanMoisDetailsComponent}
   
   ]
  },
  { path: 'collaborateur', component: CollaborateurComponent,children: [
    { path: 'client-list', component: ListClientComponent },
    { path: 'client-list-attente', component: ListClientNonValideComponent },
    { path: 'collaborateur-list', component: ListCollaborateurComponent },
    { path: 'collaborateur-new', component: AddCollaborateurComponent },
    { path: 'email-compose', component: EmailComposeComponent},
    { path: 'email-inbox', component: EmailInboxComponent},
    { path: 'email-read', component: EmailReadComponent},
    { path: 'document-add', component: AddDocumentAdminComponent}
   ]
  },
  { path: 'amc' , component: HomeTemplateComponent, children: [
    { path:'home', component: HomeComponent},
    { path:'about', component: AboutComponent},
    { path:'audit-et-certification', component: AuditEtCertificationComponent},
    { path:'assistance-juridique', component: AssistanceJuridiqueComponent},
    { path:'conseil-en-management', component: ConseilEnManagementComponent},
    { path:'services-aux-entrepreneurs', component: ServicesAuxEntrepreneursComponent},
    { path:'conseil-en-transactions', component: ConseilEnTransactionsComponent},
    { path: 'expertise', component: ExpertiseComponent},
    { path: 'carriere', component: CarriereComponent},
    { path: 'actualites', component: ActualiteComponent, children:[
    { path:'view/:id', component: PdfDetailsComponent }
    ]},
    { path: 'conventions', component: ConventionComponent, children:[
      { path:'view/:id', component: PdfDetailsComponent }
  ]},
  ]} , 
  { path: 'login', component:LoginComponent},
  { path: 'inscription', component:InscriptionComponent},
  { path: '**', component: Page404Component }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }