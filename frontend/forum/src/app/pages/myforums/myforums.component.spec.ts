import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyforumsComponent } from './myforums.component';

describe('MyforumsComponent', () => {
  let component: MyforumsComponent;
  let fixture: ComponentFixture<MyforumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyforumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyforumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
