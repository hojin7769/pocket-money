module.exports = {
    "root": true,
    "env": {
        "node": true
    },
    "extends": [
        "plugin:vue/essential",
        "eslint:recommended",
        "plugin:prettier/recommended"
    ],
    "parserOptions": {
    },
    "rules": {
        'prettier/prettier': [
            'error',
            {
                useTabs: false,
                endOfLine: 'auto',
            },
        ],
    },
};
