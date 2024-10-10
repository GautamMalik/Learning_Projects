import { TestBed } from '@angular/core/testing';

import { ResultServicesService } from './result-services.service';

describe('ResultServicesService', () => {
  let service: ResultServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResultServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
