export interface GreatDayMapsPlugin {
  getLocation(): Promise<any>;
  getLocationRadius(workLocationData: string): Promise<any>;
  getLocationLabelLanguage(options?: LabelLanguageOptions): Promise<any>;
  getLocationLabelRadiusLanguage(options?: LabelLanguageRadiusOptions): Promise<any>;
}

export interface LabelLanguageOptions{
  label1: string;
  label2: string;
  language: string;
}

export interface LabelLanguageRadiusOptions{
  label1: string;
  label2: string;
  language: string;
  location: string;
}