import { fileURLToPath, URL } from 'node:url'
import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import { quasar, transformAssetUrls } from '@quasar/vite-plugin'

export default ({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')
  return defineConfig({
    plugins: [
      vue({
        template: { transformAssetUrls }
      }),

      quasar({
        sassVariables: 'src/quasar-variables.sass'
      })
    ],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url))
      }
    },
    build: {
      outDir: '../src/main/resources/static',
      indexPath: '../static/index.html',
      cssCodeSplit: true
    },
    server: {
      hmr: {
        clientPort: env.CLIENT_PORT
      },
      proxy: {
        '/api': {
          target: env.APP_BACKEND == null ? 'http://localhost:8080' : env.APP_BACKEND,
          changeOrigin: true,
          secure: false
        }
      }
    }
  })
}
