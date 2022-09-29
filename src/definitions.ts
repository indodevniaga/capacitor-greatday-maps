export interface MapsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
