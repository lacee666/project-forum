import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedforumsComponent } from './subscribedforums.component';

describe('SubscribedforumsComponent', () => {
  let component: SubscribedforumsComponent;
  let fixture: ComponentFixture<SubscribedforumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubscribedforumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedforumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
