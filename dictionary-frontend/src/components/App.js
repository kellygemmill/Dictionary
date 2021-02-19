import React from 'react'
import { LanguageProvider, Text } from '../containers/Language';
import SearchArea from './SearchArea'
import Footer from './Footer'
import NavigationBar from './NavigationBar'

function App() {
  
    return (
        <LanguageProvider>
            <div>
                <NavigationBar className='navigation-bar' />
                <h1><Text textId='pageTitle' /></h1>
                <SearchArea />
                <Footer />
            </div>
        </LanguageProvider>
    );
}

export default App;
