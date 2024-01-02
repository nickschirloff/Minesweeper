
# Minesweeper

My own version of the classic Minesweeper game, recreated in Java using Java Swing.


## Inspiration
During my sophomore year of college, I was tasked with recreating Minesweeper in Java for one of my classes. We had been going over GUIs and event handling over the past few weeks, and this was the project to show what we had learned. This assignment turned out to be one of my favorites, as it initially presented a daunting task, but it turned out to be a really fun challenge to think about and complete.

Looking back at the old code, it was missing some aspects I wanted to add, such as a working difficulty modifier. This repo was made because I wanted to rewrite the code, and compare my growth as a developer over the years. 

My first iteration will be added under a separate branch, minus some irrelevant files or lines of code. Please keep in mind that some parts may lack implementation, and were left in to preserve the code of my first attempt.
## Screenshots

![App Screenshot](https://github.com/nickschirloff/Minesweeper/blob/main/src/demo/ms_demo_1.png)

![App Screenshot](https://github.com/nickschirloff/Minesweeper/blob/main/src/demo/ms_demo_2.png)

## Future Plans

- [ ] Recursive method to reveal nearby cells when empty cell is clicked
- [ ] Ensure first cell clicked is not a mine
## Installation

Install Java >21.0.1, and then clone the repository.

If you just want the current version:

```bash
    git clone -b main --single-branch https://github.com/nickschirloff/Minesweeper
    cd .\Minesweeper\src\
```

To get both the initial and new version:
```bash
    git clone https://github.com/nickschirloff/Minesweeper
    cd .\Minesweeper\
    git checkout first-version
```

 Finally, run with your preferred IDE.
    
## License

[MIT](https://choosealicense.com/licenses/mit/)


## Contributing

This project currently and in the future is mostly for my own development as a programmer, but I am open to pull requests if you have recommendations for optimizations or features.


## Acknowledgements

Special thanks to Dr. Crick, who assigned this project in the first place. Your class was challenging in a fun and educational way, and you were one of the best professors I had in college. Your knowledge and enthusiam about the subject of computer science has inspired myself and many of my classmates.

