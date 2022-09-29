import { WebPlugin } from '@capacitor/core';

import type { LabelLanguageOptions, LabelLanguageRadiusOptions, MapsPlugin } from './definitions';

export class MapsWeb extends WebPlugin implements MapsPlugin {
  async getLocation(): Promise<any> {
    throw new Error('Method not implemented.');
  }
  async getLocationRadius(_workLocationData?: string | undefined): Promise<any> {
    throw new Error('Method not implemented.');
  }
  async getLocationLabelLanguage(_options?: LabelLanguageOptions | undefined): Promise<any> {
    throw new Error('Method not implemented.');
  }
  async getLocationLabelRadiusLanguage(_options?: LabelLanguageRadiusOptions | undefined): Promise<any> {
    throw new Error('Method not implemented.');
  }
}
