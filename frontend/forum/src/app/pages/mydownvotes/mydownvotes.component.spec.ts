import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MydownvotesComponent } from './mydownvotes.component';

describe('MydownvotesComponent', () => {
  let component: MydownvotesComponent;
  let fixture: ComponentFixture<MydownvotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MydownvotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MydownvotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
