import { WebPlugin } from '@capacitor/core';

import type { LabelLanguageOptions, LabelLanguageRadiusOptions, GreatDayMapsPlugin } from './definitions';

export class GreatDayMapsWeb extends WebPlugin implements GreatDayMapsPlugin {
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
