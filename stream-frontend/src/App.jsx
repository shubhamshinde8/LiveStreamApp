import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import VideoUpload from './componants/VideoUpload'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <div className='flex flex-col items-center space-y-9 justify-center py-9'>
      <h1 className='font-3xl font-bold text-grey-800 dark:text-gray-100'>Video Streaming App</h1>
     <VideoUpload/>   
    </div>
    </>
  )

}

export default App
