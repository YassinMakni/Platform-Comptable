import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { routing } from './form.routing';
import { SharedModule } from '../../shared/shared.module';
import { FileUploadModule, FileSelectDirective } from 'ng2-file-upload';
import { SelectModule } from 'ng2-select';

/* components */
import { FormComponent } from './form.component';
import { FormInputsComponent } from './components/form-inputs/form-inputs.component';
import { FormLayoutsComponent } from './components/form-layouts/form-layouts.component';
import { FileUploadComponent } from './components/file-upload/file-upload.component';
import { Ng2SelectComponent } from './components/ng2-select/ng2-select.component';
import { SingleSelectComponent } from './components/ng2-select/single-select/single-select.component';
import { MultipleSelectComponent } from './components/ng2-select/multiple-select/multiple-select.component';
import { ChildrenSelectComponent } from './components/ng2-select/children-select/children-select.component';
import { ReactiveFormsModule, FormsModule } from '../../../../node_modules/@angular/forms';
import { FileListComponent } from './components/file-list/file-list.component';
import { FileViewComponent } from './components/file-view/file-view.component';
import { SafePipe } from '../../safe.pipe';
import { PdfViewerModule } from 'ng2-pdf-viewer';


@NgModule({
    imports: [
        CommonModule,
        SharedModule,
        FileUploadModule,
        SelectModule,
        routing,
        ReactiveFormsModule,
        FormsModule,
        PdfViewerModule
      
    ],
    declarations: [
        FormComponent,
        FormInputsComponent,
        FormLayoutsComponent,
        FileUploadComponent,
        Ng2SelectComponent,
        SingleSelectComponent,
        MultipleSelectComponent,
        ChildrenSelectComponent,
        FileListComponent,
        FileViewComponent,
        SafePipe
        
       
    ]
})
export class FormModule { }
