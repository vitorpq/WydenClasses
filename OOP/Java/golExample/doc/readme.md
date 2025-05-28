# Introduction

This is a _Java template project_ that includes examples of how to use a 3rd Party renderer for the Game of Life.
The Game of Life (**GOL**) implementation is an assignment for **Programming 1 - Jala University**

# Dependencies

This template has a bundled jar file **gameoflife.jar** that handles a rendering loop. 
This rendering loop allows to render a **GOL cell grid** at a _certain frequency_.

The jar file implements *two type*s of renderers:

* **ConsoleRenderer**: Renders (prints) a **GOL cell grid** in a console.
* **SwingRenderer**: Renders a **GOL cell grid** in graphical **Swing** Window.


# Usage 

The goal of the renderers is to _print_ a **GOL cell grid** (representing a **generation**) on each loop iteration.  

## Representing a GOL generation

A **GOL cell grid** is a *flat string* that represents a **GOL generation**.

For example, consider this **4x4** cell grid:

|       | col 0 | col 1 | col 2 | col 3 |
|-------|-------|-------|-------|-------|
| row 0 | 0     | 0     | 0     | 0     |
| row 1 | 1     | 0     | 1     | 0     |
| row 2 | 0     | 1     | 0     | 1     |
| row 3 | 1     | 1     | 1     | 1     |

1 = alive
0 = dead

To print this matrix in a GOL renderer you need to convert it to a **flat string** as follows:

- **Alive cells** are represented as `X` 
- **Dead cells** are represented as `.` or ` ` (space)
- To separate a **grid row** we use `\n` (escaped character) 

Thus, the previous example can be represented with this **flat string**:

`....\nX.X.\n.X.X.X\nXXXX`

## Using a Renderer

To use a GOL renderer you need to declare an implementation of a `GolGenerator` interface.
You need just to provide and implementation of the `getNextGenerationAsString` method 

Example:

``` Java
final GolGenerator generator = new GolGenerator() {
    @Override
    public String getNextGenerationAsString(long generation) {
         if (generation % 2 == 0) {
            return "XXX\nX.X\nXXX";
         }
         else
         {
            return "...\n...\n...";
         }
    }
};
```

The `getNextGenerationAsString` method is on each loop iteration by a renderer.
This method includes a `generation` parameter that indicates the current GOL **generation counter**.

In this example, we just check if generation is **odd** or **even**, and return a different GOL generation represented as a **GOL flat string** (as described in previous section).  



Once you declare a Gol Generator, you need to use it with a Gol Renderer, e.g.:

``` java
        // Will use a Terminal Console
        ConsoleRenderer.render(generator, new GolSettings(3, 3, 1000, 0));
```


This means:
- We cant to use a ConsoleRenderer using the previous generator
- We want to use specific `GolSettings` (parameters of GOL)
  - `Cols`: 3
  - `Rows`: 3
  - `Loop Frequency`: 1000
  - `Max Number of Generations`: 0 (means will run _indefinitely_)

This example will print these output over time:

```
XXX
X.X
XXX

...
...
...

XXX
X.X
XXX


...
...
...

etc...

```

To use a different renderer, you don't need to modify your generator, just change the renderer:
``` java
        // Will use a SwingRenderer Console
        SwingRenderer.render(generator, new GolSettings(3, 3, 1000, 0));
```

This will render the GOL in a Swing Graphical Window.

# Examples Included

- `GolExampleA`: Simple GOL loop with a Console renderer (even & odd switching population)
- `GolExampleB`: Simple GOL loop with a Swing renderer (even & odd switching population)
- `GolExampleC`: Simple GOL loop with a Console renderer (random population)
- `GolExampleD`: Simple GOL loop with a Swing renderer (random population)
- `GolSkeletonA`: Simple GOL loop skeleton to illustrate how to use a `int [][]` matrix (inverting population) with a Console renderer (includes an initial population) 
- `GolSkeletonB`: Simple GOL loop skeleton to illustrate how to use a `int [][]` matrix (inverting population) with a Swing renderer (includes an initial population)
- `GolInverter`: A simple `GolGenerator` that inverts a matrix en each generation.

# Notice
Code example and library created by [Javier Roca](mailto:javier.roca@jala.university)

This is educational material property of **Jala University**. Do not distributye.
