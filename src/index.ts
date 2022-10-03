import { registerPlugin } from '@capacitor/core';

import type { GreatDayMapsPlugin } from './definitions';

const GreatDayMaps = registerPlugin<GreatDayMapsPlugin>('GreatDayMaps', {
  web: () => import('./web').then(m => new m.GreatDayMapsWeb()),
});

export * from './definitions';
export { GreatDayMaps };
