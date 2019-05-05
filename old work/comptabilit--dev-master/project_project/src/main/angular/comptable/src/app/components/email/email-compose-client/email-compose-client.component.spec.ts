import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailComposeClientComponent } from './email-compose-client.component';

describe('EmailComposeClientComponent', () => {
  let component: EmailComposeClientComponent;
  let fixture: ComponentFixture<EmailComposeClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmailComposeClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailComposeClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
