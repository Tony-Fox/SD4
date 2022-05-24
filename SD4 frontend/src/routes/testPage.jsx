import * as React from "react";
import {useParams} from "react-router-dom";

export default function TestPage() {

    let params = useParams();
    return (
        <main style={{ padding: '1rem 0' }}>
            <h2>
                Test Page
                {params.restaurantId}

            </h2>

        </main>
    );
}
