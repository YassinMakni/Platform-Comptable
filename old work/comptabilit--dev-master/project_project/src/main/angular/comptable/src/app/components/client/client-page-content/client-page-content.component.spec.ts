import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientPageContentComponent } from './client-page-content.component';

describe('ClientPageContentComponent', () => {
  let component: ClientPageContentComponent;
  let fixture: ComponentFixture<ClientPageContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientPageContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientPageContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
