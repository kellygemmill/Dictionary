import React from 'react'
import { LanguageProvider, Text } from 'containers/Language';
import SearchArea from 'components/SearchArea'
import Footer from 'components/Footer'
import NavigationBar from 'components/NavigationBar'

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
