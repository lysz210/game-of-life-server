# Game Of Life Server

Api for processing a single cell of "Game Of Life". It will receive a 3x3 matrix of 0s and 1s where the ceter is the cell to be processed with the following rules:

| initial | new | condition |
|------|-------| ----------|
| 1 | 1 | with two or three neighbors 1 |
| 0 | 1 | with three 1 neighbors |
| any | 0 | other conditions |
